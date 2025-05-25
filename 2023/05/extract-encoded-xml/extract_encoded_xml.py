import xml.etree.ElementTree as ET
from xml.dom import minidom
import csv

tree = ET.parse("example_encoded_xml.xml")
root = tree.getroot()

encoded_xml = ET.fromstring(root.find("content").text)
xmlstr = minidom.parseString(ET.tostring(encoded_xml)).toprettyxml(indent="   ")

print(xmlstr)

key_value_pairs = {}
for entry in encoded_xml.iter('entry'):
    key_value_pairs[entry.attrib['key']] = entry.attrib['value']

print(key_value_pairs)

with open('key-value-output.csv', 'w', newline='') as output:
    writer = csv.writer(output)

    writer.writerow(["Key", "Value"])
    for key, value in key_value_pairs.items():
        writer.writerow([key, value])

