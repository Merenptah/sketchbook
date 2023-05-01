import pandas as pd

timerecords = pd.read_excel("test.xls")
timerecords["date"] = pd.to_datetime(timerecords["CheckIn"]).dt.date

current_date = None
report = ""
for i in range(len(timerecords.values)):
    date = timerecords["date"][i]
    if current_date != date:
        current_date = date
        report += "\n* {}. {}\n".format(timerecords["Day"][i], date.strftime('%d.%m.'))

    report += "{} - {} {} {}\n".format(
        timerecords["CheckIn"][i].strftime('%H:%M'),
        timerecords["CheckOut"][i].strftime('%H:%M'),
        timerecords["Task"][i],
        timerecords["Notes"][i])

print(report)
