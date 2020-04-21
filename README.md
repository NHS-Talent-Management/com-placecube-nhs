# README #

##COM-PLACECUBE-NHS

###Supported versions

Liferay 7.2 SP1 + Fix Pack 4

Java JDK 8


##External Placecube dependencies used
###com-pfiks-expando
Repo URL: https://bitbucket.org/pfiks/com-pfiks-expando/

Dependency used:
* group: 'com.pfiks.expando', name: 'com.pfiks.expando.api', version: '2.0.0'

###com-pfiks-mail
Repo URL: https://bitbucket.org/pfiks/com-pfiks-mail/

Dependency used:
* group: 'com.pfiks.mail', name: 'com.pfiks.mail.api', version: '2.0.0'

###com-pfiks-journal
Repo URL: https://bitbucket.org/pfiks/com-pfiks-journal

Dependency used:
* group: 'com.pfiks.journal', name: 'com.pfiks.journalcontent.renderer.web', version: '3.0.0'

###liferay-bridge
Repo URL: https://bitbucket.org/pfiks/liferay-bridge

Dependency used:
* group: 'placecube-liferay-bridge', name: 'com.placecube.journal.api', version: '1.0.0'
* group: 'placecube-liferay-bridge', name: 'com.placecube.initializer.api', version: '1.0.0'


##Modules

###com.placecube.nhs.announcementsbanner.web
Portlet to display announcements to the user.

###com.placecube.nhs.assetpublisher.provider
An Asset publisher Content provider has been implemented to retrieve blogs from the whole company. This can be configured in the liferay asset publisher portlet. This was to avoid having custom portlets for blogs listing.

###com.placecube.nhs.communitylisting.web
This module contains custom portlets to list the A-Z communities, My communities, Most popular communities and the Community membership button

###com.placecube.nhs.fragmentcollection
To facilitate the configuration of pages, custom fragments have been created.
* Action link, which allows the user to enter a link styled as the NHS action link pattern
* Community intro, which displays the group details and includes the community membership button portlet.
* Web content display, which allows to configure 1 web content article to display to logged out users and 1 to display to logged in users

###com.placecube.nhs.grouptypes
Module to automatically create the expando field ‘group-type’ used to identify groups of type CoI or CoP

###com.placecube.nhs.indexer.group
Module to add a custom indexer for entities of type ‘Group’ as Liferay OOTB does not index groups.

###com.placecube.nhs.language
Module that contains language override labels and labels used in the theme so that the theme is fully localized

###com.placecube.nhs.notification.api, com.placecube.nhs.notification.service
Modules to manage user notifications.
Service builder modules to create the custom database tables 
* `NHS_Notification_UserNotificationPreference`: Used to store what type of notification the user has enabled, .e.g EMAIL enabled = true/false
* `NHS_Notification_Notification`: Used to store a notification created by the talend dashboard module that will be sent to users
Notifications are not sent immediately from the talent dashboard. A background task entry is generated following Liferay’s approach. When the next executor is available, the background task is executed and notifications (currently only supported type is email) are sent to users.

The module also automatically creates the web content in the global group used as email template

###com.placecube.nhs.override.commenttaglib.jsp
Liferay JSP Override to change the ‘Reply to..’ label to ‘Join to comment’.
The override uses the liferay-util buffer approach to keep the override as simple and clean as possible.

###com.placecube.nhs.override.facebooklogin.jsp
Liferay JSP Override to style and configure the label for the Facebook SSO button displayed on the login/registration screens. This is because Liferay only adds the text ‘Facebook’ when the integration is done using the OOTB OpenIdConnect instead of displaying the standard ‘Connect with Facebook’ blue button.
The override uses the liferay-util buffer approach to keep the override as simple and clean as possible.

###com.placecube.nhs.override.login.jsp
Liferay JSP Override to redirect the user to the custom registration form.
The override uses the liferay-util buffer approach to keep the override as simple and clean as possible.

###com.placecube.nhs.readiness.api, com.placecube.nhs.readiness.service
API to configure, retrieve, update the Readiness questionnaire.
The module also automatically creates the web content in the global group for the questionnaire intro text and confirmation text.

###com.placecube.nhs.readiness.web
Custom portlet to display the readiness questionnaire and summary.

###com.placecube.nhs.registration.web
Custom registration portlet.
The module also automatically creates the web content in the global group. The web content is currently used to display intro text in the portlet.

###com.placecube.nhs.search.utils
Module with common utils to execute searches

###com.placecube.nhs.setup
Module to automatically create
* web content used as theme footer
* widget template for the navigation, which is used in the header. The template will display the pages of the group the user is currently in, plus a fixed link to the ‘My account’ page and a fixed link to logout (if user is logged in)
* widget template for the asset publisher portlet to display of blogs
* widget template for the blogs entry portlet to display of blogs

###com.placecube.nhs.taglibs
Module containing various custom taglibs implemented to support the NHS design patterns, e.g. A-Z listing, form field types

###com.placecube.nhs.talentdashboard.web
Custom portlet for the talent dashboard.
The module also automatically creates the web content in the global group. The web content is currently used to display custom text in the portlet.

###com.placecube.nhs.talentsearch.api, com.placecube.nhs.talentsearch.service
Service builder module to create the custom database table `NHS_TalentSearch_TalentSearch` where the campaigns generated from the talent dashboard are saved.

###com.placecube.nhs.template.utils
Module to provide some utils used in the various templates, e.g. web content templates 

###com.placecube.nhs.user.expando
Module to automatically generate the user expando fields used by the platform. 
Currently the readiness questionnaire only included expando fields for the User object, to allow administrators to easily add/update questions.

###com.placecube.nhs.user.profile.web
Module that contains custom portlets currently displayed on the user profile page, which include
* Profile details
* Experience
* Learning and skills
* Professional bodies

The module also automatically creates the web content in the global group. The web content is currently used to mock the ‘Import from source’ screen.

###com.placecube.nhs.user.settings.web
Custom portlet to allow the user to change their settings for privacy and communication preferences.

###com.placecube.nhs.userprivacy.api, com.placecube.nhs.userprivacy.service
Service builder module to create the custom table `NHS_Privacy_UserPrivacy`. This table is used to store the user preferences for the privacy level for each area, profile, experince, readiness questionnaire, etc. 

###com.placecube.nhs.userprofile.api, com.placecube.nhs.userprofile.service
Service builder module to create the custom tables
* `NHS_Experience`
* `NHS_Qualification`
* `NHS_ProfessionalBody`

###com.placecube.nhs.webcontent.listing.web
Custom portlets to list A-Z and most popular Web contents based on a configured structure.

###com.placecube.nhs.webcontent.structures
Module to automatically create the Course and Job web content structure and templates in the global group
