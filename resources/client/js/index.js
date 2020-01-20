function pageLoadCheckout() {

    let now = new Date();

    let myHTML = '<div style="text-align:Left;">'
        + '<button onclick="window.location.href = \'http://localhost:8081/client/index.html\';">Home</button>'
        + '<div style="text-align:center;">'
        + '<img src="/client/img/Hawkeye.PNG"  alt="Logo"/>'
        + '<div style="text-align:left;">'
        + '<h2>My Basket:</h2>'
        + '<h4>Enter Voucher Below</h4>'
        + '<form>'
        + '<input type="text" name="Voucher">'
        + '</form>'
        + '<button onclick= //javascriptforvoucher>Apply</button>'
        + '<div style="text-align:center;">'
        + '<button onclick="window.location.href = \'http://localhost:8081/client/delivery.html\';">Proceed To Checkout</button>'
        + '<div style="font-style: italic;" style="text-align:right;">'
        + 'Generated at ' + now.toLocaleTimeString()

    document.getElementById("testDiv").innerHTML = myHTML;

}

function pageLoadIndex() {

    let now = new Date();

    let myHTML = '<div style="text-align:Left;">'
        + '<button onclick="window.location.href = \'http://localhost:8081/client/index.html\';">Home</button>'
        + '<button onclick="window.location.href = \'http://localhost:8081/client/checkout.html\';">Basket</button>'
        + '<div style="text-align:center;">'
        + '<img src="/client/img/Hawkeye.PNG"  alt="Logo"/>'
        + '<img src="/client/img/PizzaBanner.jpg"  alt="Logo"/>'
        + '<h2 style="text-align:right;">Small Medium Large</h2>'
        + '<div style="text-align:Left;">'
        + '<h2>Margerhita</h2>'
        + '<button>Add Small</button>'
        + '<button>Add Medium</button>'
        + '<button>Add Large</button>'
        + '<h2 style="text-align:right;">8.99 10.99 13.99</h2>'
        + '<div style="text-align:Left;">'
        + '<h2>Pepperoni</h2>'
        + '<button>Add Small</button>'
        + '<button>Add Medium</button>'
        + '<button>Add Large</button>'
        + '<h2 style="text-align:right;">9.99 12.99 15.99</h2>'
        + '<div style="text-align:Left;">'
        + '<h2>Meat Feast</h2>'
        + '<button>Add Small</button>'
        + '<button>Add Medium</button>'
        + '<button>Add Large</button>'
        + '<h2 style="text-align:right;">9.99 12.99 15.99</h2>'
        + '<div style="text-align:Left;">'
        + '<h2>Vegi Passion</h2>'
        + '<button>Add Small</button>'
        + '<button>Add Medium</button>'
        + '<button>Add Large</button>'
        + '<h2 style="text-align:right;">9.99 12.99 15.99</h2>'
        + '<div style="text-align:Left;">'
        + '<h2>Seafood Supreme</h2>'
        + '<button>Add Small</button>'
        + '<button>Add Medium</button>'
        + '<button>Add Large</button>'
        + '<h2 style="text-align:right;">9.99 12.99 15.99</h2>'
        + '<div style="font-style: italic;">'
        + 'Generated at ' + now.toLocaleTimeString()
        + '</div>';

    document.getElementById("testDiv").innerHTML = myHTML;

}
function pageLoadPayment() {

    let now = new Date();

    let myHTML = '<div style="text-align:Left;">'
        + '<button onclick="window.location.href = \'http://localhost:8081/client/index.html\';">Home</button>'
        + '<button onclick="window.location.href = \'http://localhost:8081/client/checkout.html\';">Basket</button>'
        + '<div style="text-align:center;">'
        + '<img src="/client/img/Hawkeye.PNG"  alt="Logo"/>'
        + '<div style="text-align:left;">'

        + '<h4>Forename</h4>'
        + '<form>'
        + '<input type="text" name="CustomerName">'
        + '</form>'

        + '<h4>16-Digit Card Number</h4>'
        + '<form>'
        + '<input type="text" name="CardNo">'
        + '</form>'

        + '<h4>Expiry Date</h4>'
        + '<form>'
        + '<input type="text" name="ExpiryDate">'
        + '</form>'

        + '<h4>CCV</h4>'
        + '<form>'
        + '<input type="text" name="CCV">'
        + '</form>'
        + '<div style="text-align:center;">'
        + '<button onclick="window.location.href = \'http://localhost:8081/client/success.html\';">Make Payment</button>'
        + '<div style="font-style: italic;">'
        + 'Generated at ' + now.toLocaleTimeString()
        + '</div>';


    document.getElementById("testDiv").innerHTML = myHTML;

}
function pageLoadDelivery() {

    let now = new Date();

    let myHTML = '<div style="text-align:Left;">'
        + '<button onclick="window.location.href = \'http://localhost:8081/client/index.html\';">Home</button>'
        + '<button onclick="window.location.href = \'http://localhost:8081/client/checkout.html\';">Basket</button>'
        + '<div style="text-align:center;">'
        + '<img src="/client/img/Hawkeye.PNG"  alt="Logo"/>'
        + '<div style="text-align:left;">'

        + '<h4>House Number</h4>'
        + '<form>'
        + '<input type="text" name="HouseNumber">'
        + '</form>'

        + '<h4>Street Name</h4>'
        + '<form>'
        + '<input type="text" name="StreetName">'
        + '</form>'

        + '<h4>Town</h4>'
        + '<form>'
        + '<input type="text" name="Town">'
        + '</form>'

        + '<h4>Postcode</h4>'
        + '<form>'
        + '<input type="text" name="Postcode">'
        + '</form>'

        + '<div style="text-align:center;">'
        + '<button onclick="window.location.href = \'http://localhost:8081/client/payment.html\';">Proceed To Payment</button>'

        + '<div style="font-style: italic;">'
        + 'Generated at ' + now.toLocaleTimeString()
        + '</div>';

    document.getElementById("testDiv").innerHTML = myHTML;

}
function pageLoadSuccess() {

    let now = new Date();

    let myHTML = '<div style="text-align:Left;">'
        + '<button onclick="window.location.href = \'http://localhost:8081/client/index.html\';">Home</button>'
        + '<button onclick="window.location.href = \'http://localhost:8081/client/checkout.html\';">Basket</button>'
        + '<div style="text-align:center;">'
        + '<img src="/client/img/Hawkeye.PNG"  alt="Logo"/>'
        + '<h1>Payment Successful</h1>'
        + '<h3>Your order will be with you shortly</h3>'

        + '<div style="font-style: italic;">'
        + 'Generated at ' + now.toLocaleTimeString()
        + '</div>';

    document.getElementById("testDiv").innerHTML = myHTML;

}