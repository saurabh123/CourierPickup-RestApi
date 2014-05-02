RestApi
=======

A Restful Webservice API for Creating Courier Pickup Request.


Developed using Jersey 1.18 .


exposed URI details and documentation can be found at : 
http://docs.restapi101.apiary.io/

Sample Response JSON Array format

{  {"id": 1,"user": "testuser","weight": 3,"createdDate": 1398978496084,"pickupSlot": "2 PM - 3 PM",
        "packageCount": 2,
        "type": "paracle",
        "pickupAddId": 0,
        "scheduledDate": null,
        "status": 1,
        "statusDesc": null,
        "pickupAddress": {
            "contactName": "saurabh",
            "companyName": "liftoff",
            "address1": "abc street",
            "address2": "xyz road",
            "country": "india",
            "city": "Chennai",
            "state": "Tamil Nadu",
            "zipcode": 600036,
            "phoneNo": 9898787
        },
        "deliveryAddress": {
            "contactName": "saurabh",
            "companyName": "liftoff",
            "address1": "abc street",
            "address2": "xyz road",
            "country": "india",
            "city": "Chennai",
            "state": "Tamil Nadu",
            "zipcode": 600036,
            "phoneNo": 9898787
        }
    },
    {
        "id": 1,
        "user": "testuser",
        "weight": 2,
        "createdDate": 1398978496084,
        "pickupSlot": "3 PM - 4PM",
        "packageCount": 1,
        "type": "paracle",
        "pickupAddId": 0,
        "scheduledDate": null,
        "status": 2,
        "statusDesc": null,
        "pickupAddress": {
            "contactName": "saurabh",
            "companyName": "liftoff",
            "address1": "abc street",
            "address2": "xyz road",
            "country": "india",
            "city": "Chennai",
            "state": "Tamil Nadu",
            "zipcode": 600036,
            "phoneNo": 9898787
        },
        "deliveryAddress": {
            "contactName": "saurabh",
            "companyName": "liftoff",
            "address1": "abc street",
            "address2": "xyz road",
            "country": "india",
            "city": "Chennai",
            "state": "Tamil Nadu",
            "zipcode": 600036,
            "phoneNo": 9898787
        }
    }
