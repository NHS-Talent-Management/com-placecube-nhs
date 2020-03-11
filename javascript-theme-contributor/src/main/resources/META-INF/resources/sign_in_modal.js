var	NAME = 'nhssigninmodal';
AUI.add(
	'nhs-sign-in-modal',
	function(A) {

		var WIN = A.config.win;

		var NHSSignInModal = A.Component.create(
			{
				ATTRS: {
					resetFormValidator: {
						value: true
					},

					signInPortlet: {
						setter: A.one,
						value: '#p_p_id_com_liferay_login_web_portlet_LoginPortlet_'
					}
				},

				EXTENDS: A.Plugin.Base,

				NAME: NAME,

				NS: NAME,

				prototype: {
					initializer: function(config) {
						var instance = this;

						var signInPortlet = instance.get('signInPortlet');

						if (signInPortlet) {
							instance._signInPortletBody = signInPortlet.one('.portlet-content');
						}

						var host = instance.get('host');

						instance._host = host;
						instance._signInPortlet = signInPortlet;

						instance._signInURL = host.attr('href');

						if (signInPortlet) {
							var formNode = signInPortlet.one('form');

							if (formNode) {
								var form = Liferay.Form.get(formNode.attr('id'));

								instance._formValidator = '';

								if (form) {
									instance._formValidator = form.formValidator;
								}

								instance._hasSignInForm = formNode.hasClass('sign-in-form');
								
							}
						}

						instance._bindUI();
					},

					destructor: function() {
						var dialog = Liferay.Util.getWindow(NAME);

						if (dialog) {
							dialog.destroy();
						}
					},

					_bindUI: function() {
						var instance = this;
						instance._host.on('click', A.bind('_load', instance));

						var destroyModal = function(event) {
							instance.destroy();

							Liferay.detach('screenLoad', destroyModal);
						};

						Liferay.on('screenLoad', destroyModal);
					},

					_load: function(event) {
						var instance = this;

						event.preventDefault();

						if (instance._signInPortletBody && instance._hasSignInForm) {
							instance._loadDOM();
						}
						else {
							instance._loadIO();
						}
					},

					_loadDOM: function() {
						var instance = this;

						var signInPortletBody = instance._signInPortletBody;

						if (!instance._originalParentNode) {
							instance._originalParentNode = signInPortletBody.ancestor();
						}

						instance._setModalContent(signInPortletBody);

						var uri = new A.Url(instance._signInURL);

						var redirect = uri.getParameter('redirect');

						Liferay.Util.focusFormField(signInPortletBody.one('input:text'));
					},

					_loadIO: function() {
						var instance = this;

						var modalSignInURL = Liferay.Util.addParams('windowState=exclusive', instance._signInURL);

						A.io.request(
							modalSignInURL,
							{
								on: {
									failure: A.bind('_redirectPage', instance),
									success: function(event, id, obj) {
										var responseData = this.get('responseData');

										if (responseData) {
											instance._setModalContent(responseData);
										}
										else {
											instance._redirectPage();
										}
									}
								}
							}
						);
					},

					_redirectPage: function() {
						var instance = this;
						WIN.location.href = instance._redirectPage;
					},

					_setModalContent: function(content) {
						var instance = this;
						
						var uri = new A.Url(instance._signInURL);

						var redirect = uri.getParameter('redirect');
						var currentURL = $(location).attr('href');
						var portletURL = new Liferay.PortletURL.createRenderURL(currentURL);

						portletURL.setPortletId('com_liferay_login_web_portlet_FastLoginPortlet');
						portletURL.setWindowState('POP_UP');
						portletURL.setParameter('p_auth', Liferay.authToken);
						portletURL.setParameter('redirect', redirect);

						Liferay.Util.openWindow(
							{
								dialog: {
									destroyOnHide: true,
									height: 605,
									width: 340
								},
								id: NAME,
								title: Liferay.Language.get('sign-in'),
								uri: portletURL.toString()
							}
						);
					}
				}
			}
		);

		Liferay.NHSSignInModal = NHSSignInModal;
	},
	'',
	{
		requires: ['aui-base', 'aui-component', 'aui-io-request', 'aui-parse-content', 'liferay-form', 'liferay-portlet-url', 'liferay-util-window', 'plugin']
	}
);

AUI().ready('aui-module', function(A){ 
	var popUp = Liferay.Util.getWindow(NAME);
	if (Liferay.ThemeDisplay.isSignedIn() && typeof popUp != 'undefined') {
		window.top.location.reload();
		popUp.destroy();
	}
});