A slack bot app which is used to publish broadcast messages.

Steps to use this app:

Once this app is up and running

For a consumer:

 1. Login to the workspace: SaDr
 2. Add the app named 'CollectApp'
 3. Whenever the broadcaster publishes a message
    using 'http://localhost:8080/broadcast', it
    will be pushed to all the users who is using
    this App

    Sample curl for broadcast:

    curl --location --request POST 'http://localhost:8080/broadcast' \
    --header 'Content-Type: text/plain' \
    --data-raw 'Hello World!'

For an Admin:
 1. Currently, no environmental variable or external configuration server
    of the slack app. It is hardcoded in the application.properties file. So, if
    we need to change the workspace and or app, need to update the URI in this file
    and run this server.
