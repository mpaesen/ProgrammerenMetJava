import mysql.connector


def getSQLExpression(MySQLQuery):
    cnx = mysql.connector.connect(user='Mathy', password='Npngnmtj0',
                                  host='127.0.0.1',
                                  database='mButeo')
    query = MySQLQuery
    cursor = cnx.cursor()
    cursor.execute(query)
    records = cursor.fetchall()
    cursor.close()
    cnx.close()
    return records



def getInvoiceTurnover(year):
    MySQLQuery = ("""select cusname as Naam, cusvat as BTW, sum(b.invQty * b.invPrice) as omzet from invoicesview a inner join invoicedetail b 
on a.idinvoice = b.idInvoice join address c
on a.invaddid = c.idAddress
where invdate between '2018-01-01' and '2018-12-31'
and c.addCountry = 'Bel'
group by invcusid
union
select '', 'Total',sum(b.invQty * b.invPrice) as omzet from invoicesview a inner join invoicedetail b 
on a.idinvoice = b.idInvoice join address c
on a.invaddid = c.idAddress
where invdate between '2018-01-01' and '2018-12-31'
and c.addCountry = 'Bel'""")
    records = getSQLExpression(MySQLQuery)
    for row in records:
        print("\n{}".format(row))
    return None


getInvoiceTurnover(2018)


