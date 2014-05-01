RestApi
=======

A Restful Webservice API for Creating Courier Pickup Request.


Developed using Jersey 1.18 .


For exposed URI details and documentation visit :



JSONDATA FORMAT :
[
{
    "id": 1,
    "user": "testuser",
    "weight": 3,
    "createdDate": 1398978496084,
    "pickupSlot": "2 PM - 3 PM",
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
}

]
