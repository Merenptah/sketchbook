# Extracting encoded XML

Say you have an XML file which contains encoded xml as one field, like in
```xml
<?xml version="1.0" encoding="UTF-8"?>
<envelope>
	<content>&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?&gt;&lt;map&gt;&lt;entry key=&quot;key1&quot; value=&quot;test&quot;/&gt;&lt;entry key=&quot;key2&quot; value=&quot;other test&quot;/&gt;&lt;/map&gt;</content>
</envelope>
```

We read this file, extract this encoded XML, and then
- print it (you can further save it in a separate file)
- extract some key value pairs and save them in a csv file