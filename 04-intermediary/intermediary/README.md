# Optional lowercase transformation

The following SOAP header can be used to convert all text nodes into lowercase format:

```xml
<soapenv:Header><tweak lowercase="true" xmlns="http://tweaks.com/"/></soapenv:Header>
```

## SOAP request example

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:trip="http://trip_planner.example.org/">
   <soapenv:Header><tweak lowercase="true" xmlns="http://tweaks.com/"/></soapenv:Header>
   <soapenv:Body>
      <trip:viewMyTrips/>
   </soapenv:Body>
</soapenv:Envelope>
```

### Default response

```xml
<?xml version='1.0' encoding='UTF-8'?>
<S:Envelope
	xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
	<S:Body>
		<ns2:viewMyTripsResponse
			xmlns:ns2="http://trip_planner.example.org/">
			<return>
				<uuid>85ff567f-386a-392b-b22e-68611cefc352</uuid>
				<name>Sightseeing in Rome</name>
				<dateFrom>2023-05-01T00:00:00+02:00</dateFrom>
				<dateTo>2023-05-05T00:00:00+02:00</dateTo>
				<locationCity>Rome</locationCity>
				<locationCountry>Italy</locationCountry>
				<accommodation>
					<isBooked>true</isBooked>
					<name>Hotel Golden</name>
					<address>
						<streetAddress>Via Marche, 84</streetAddress>
						<city>Rome</city>
						<country>Italy</country>
					</address>
				</accommodation>
			</return>
			<return>
				<uuid>7de53c3e-acec-3fe9-a839-64e5cfa5c251</uuid>
				<name>Surfing in Portugal</name>
				<dateFrom>2023-08-12T00:00:00+02:00</dateFrom>
				<dateTo>2023-08-20T00:00:00+02:00</dateTo>
				<locationCity>Peniche</locationCity>
				<locationCountry>Portugal</locationCountry>
				<accommodation>
					<isBooked>true</isBooked>
					<name>Hotel MH Peniche</name>
					<address>
						<streetAddress>Av. Monsenhor Bastos, 2520-206</streetAddress>
						<city>Peniche</city>
						<country>Portugal</country>
					</address>
				</accommodation>
			</return>
		</ns2:viewMyTripsResponse>
	</S:Body>
</S:Envelope>
```

### Lowercase response

```xml
<?xml version='1.0' encoding='UTF-8'?>
<S:Envelope
	xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
	<S:Header>
		<trip:tweaked
			xmlns="http://tweaks.com/"
			xmlns:trip="http://trip_planner.example.org/">Lowercase transformation applied
		</trip:tweaked>
	</S:Header>
	<S:Body>
		<ns2:viewMyTripsResponse
			xmlns:ns2="http://trip_planner.example.org/">
			<return>
				<uuid>85ff567f-386a-392b-b22e-68611cefc352</uuid>
				<name>sightseeing in rome</name>
				<dateFrom>2023-05-01t00:00:00+02:00</dateFrom>
				<dateTo>2023-05-05t00:00:00+02:00</dateTo>
				<locationCity>rome</locationCity>
				<locationCountry>italy</locationCountry>
				<accommodation>
					<isBooked>true</isBooked>
					<name>hotel golden</name>
					<address>
						<streetAddress>via marche, 84</streetAddress>
						<city>rome</city>
						<country>italy</country>
					</address>
				</accommodation>
			</return>
			<return>
				<uuid>7de53c3e-acec-3fe9-a839-64e5cfa5c251</uuid>
				<name>surfing in portugal</name>
				<dateFrom>2023-08-12t00:00:00+02:00</dateFrom>
				<dateTo>2023-08-20t00:00:00+02:00</dateTo>
				<locationCity>peniche</locationCity>
				<locationCountry>portugal</locationCountry>
				<accommodation>
					<isBooked>true</isBooked>
					<name>hotel mh peniche</name>
					<address>
						<streetAddress>av. monsenhor bastos, 2520-206</streetAddress>
						<city>peniche</city>
						<country>portugal</country>
					</address>
				</accommodation>
			</return>
		</ns2:viewMyTripsResponse>
	</S:Body>
</S:Envelope>
```

