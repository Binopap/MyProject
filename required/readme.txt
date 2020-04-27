Save the key in c:/serverkey/

2. add/replace the the following in server.xml

<Connector SSLEnabled="true" acceptCount="100" clientAuth="false" debug="0" disableUploadTimeout="true" enableLookups="true" keystoreFile="c:/serverkeys/clientkeystore.key" keystorePass="alfaleader123" maxSpareThreads="75" maxThreads="150" minSpareThreads="25" port="8443" scheme="https" secure="true" sslProtocol="TLS"/> 