# ABN4Java
[![Build Status](https://travis-ci.org/mlew980/ABN4Java.svg?branch=master)](https://travis-ci.org/mlew980/ABN4Java)
This project allows for easy Java integration with the ABN web-services (JSON) provided by the Australian Government.

## Getting Started - GUID Key
Before using this library **you need the GUID key**, you can register for it [here](https://abr.business.gov.au/Tools/WebServices).

Once you get the key, you can test the type of results you may expect, as well as the expected inputs. The testing web interface can be found [here](https://abr.business.gov.au/json/).

## Installing - Maven
~~~~
git clone https://github.com/mlew980/ABN4Java.git
mvn package
~~~~

## Usage 
```java
ABN4Java abnClient = new ABN4Java("<guid>");
try {
  //ABN Lookup - Name Search - Refer to object properties
  List<Company> companies = abnClient.ABNLookupNameSearch("department of Industry");
  
  //ABN Lookup - ABN search - Refer to object properties
  ABN abn = abnClient.ABNLookupABNSearch("74172177893");
  
  //ABN Lookup - ACN search - Refer to object properties
  ABN abn = abnClient.ABNLookupACNSearch("008672179");
  
} catch (ABN4JavaExecutionException e) {
  e.printStackTrace();
}
```
## Available Methods
| Return Type | Name of Method | Parameter Type | Parameter Description |
|---|---|---|---|
| ABN | ABNLookupABNSearch | String | Searching for company details using ABN number.  |
| ABN | ABNLookupACNSearch | String | Searching for company details using ACN number. |
| List\<Company\> | ABNLookupNameSearch | String | Searching for companies and their ABN details. |

## ABN Object Fields
| Type | Name |
|---|---|
| String | Abn |
| String | AbnStatus |
| Date | AddressDate |
| String | AddressPostcode |
| String | AddressState |
| List<String> | BusinessName |
| String | EntityName |
| String | EntityTypeCode |
| String | EntityTypeName |
| Date | Gst |
| String | Message |

## Company Object Fields
| Type | Name |
|---|---|
| String | Abn |
| String | AbnStatus |
| boolean | IsCurrent |
| String | Name |
| String | NameType |
| String | Postcode |
| int | Score |
| String | State |
