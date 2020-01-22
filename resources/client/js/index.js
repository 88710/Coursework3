function pageLoadCheckout() {

    let now = new Date();

    let myHTML = '<div style="text-align:Left;">'
        + '<button onclick="window.location.href = \'http://localhost:8081/client/index.html\';">Home</button>'
        + '<button onclick="window.location.href = \'http://localhost:8081/client/checkout.html\';">Basket</button>'
        + '<button onclick="window.location.href = \'http://localhost:8081/client/AdminLogin.html\';">Admin</button>'
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
        + '<button onclick="window.location.href = \'http://localhost:8081/client/AdminLogin.html\';">Admin</button>'
        + '<div style="text-align:center;">'
        + '<img src="/client/img/Hawkeye.PNG"  alt="Logo"/>'
        + '<img src="/client/img/PizzaBanner.jpg"  alt="Logo"/>'
        + '<h2 style="text-align:right;">Small Medium Large</h2>'
        + '<div style="text-align:Left;">'
        + '<h2>Margerhita</h2>'
        + '<button>Small</button>'
        + '<button>Medium</button>'
        + '<button>Large</button>'
        + '<h2 style="text-align:right;">8.99 10.99 13.99</h2>'
        + '<div style="text-align:Left;">'
        + '<h2>Pepperoni</h2>'
        + '<button>Small</button>'
        + '<button>Medium</button>'
        + '<button>Large</button>'
        + '<h2 style="text-align:right;">9.99 12.99 15.99</h2>'
        + '<div style="text-align:Left;">'
        + '<h2>Meat Feast</h2>'
        + '<button>Small</button>'
        + '<button>Medium</button>'
        + '<button>Large</button>'
        + '<h2 style="text-align:right;">9.99 12.99 15.99</h2>'
        + '<div style="text-align:Left;">'
        + '<h2>Vegi Passion</h2>'
        + '<button>Small</button>'
        + '<button>Medium</button>'
        + '<button>Large</button>'
        + '<h2 style="text-align:right;">9.99 12.99 15.99</h2>'
        + '<div style="text-align:Left;">'
        + '<h2>Seafood Supreme</h2>'
        + '<button>Small</button>'
        + '<button>Medium</button>'
        + '<button>Large</button>'
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
        + '<button onclick="window.location.href = \'http://localhost:8081/client/AdminLogin.html\';">Admin</button>'
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
        + '<button onclick="window.location.href = \'http://localhost:8081/client/AdminLogin.html\';">Admin</button>'
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
        + '<button onclick="window.location.href = \'http://localhost:8081/client/AdminLogin.html\';">Admin</button>'

        + '<div style="text-align:center;">'
        + '<img src="/client/img/Hawkeye.PNG"  alt="Logo"/>'
        + '<h1>Payment Successful</h1>'
        + '<h3>Your order will be with you shortly</h3>'

        + '<div style="font-style: italic;">'
        + 'Generated at ' + now.toLocaleTimeString()
        + '</div>';

    document.getElementById("testDiv").innerHTML = myHTML;

}
function pageLoadAdmin() {

    let now = new Date();

    let myHTML = '<div style="text-align:Left;">'
        + '<button onclick="window.location.href = \'http://localhost:8081/client/index.html\';">Home</button>'
        + '<button onclick="window.location.href = \'http://localhost:8081/client/checkout.html\';">Basket</button>'
        + '<button onclick="window.location.href = \'http://localhost:8081/client/AdminLogin.html\';">Admin</button>'
        + '<div style="text-align:center;">'
        + '<img src="/client/img/Hawkeye.PNG"  alt="Logo"/>'
        + '<div style="font-style: italic;">'
        + 'Generated at ' + now.toLocaleTimeString()
        + '</div>';

    document.getElementById("testDiv").innerHTML = myHTML;

}
function pageLoadAdminLogin() {

    let now = new Date();

    let myHTML = '<div style="text-align:Left;">'
        + '<button onclick="window.location.href = \'http://localhost:8081/client/index.html\';">Home</button>'
        + '<button onclick="window.location.href = \'http://localhost:8081/client/checkout.html\';">Basket</button>'
        + '<button onclick="window.location.href = \'http://localhost:8081/client/AdminLogin.html\';">Admin</button>'
        + '<div style="text-align:center;">'
        + '<img src="/client/img/Hawkeye.PNG"  alt="Logo"/>'
        + '<h4>Admin Password</h4>'
        + '<form>'
        + '<input type="text" name="AdminPass">'
        + '</form>'
        + '<button onclick="window.location.href = \'http://localhost:8081/client/Admin.html\';">Login</button>'
        + '<div style="font-style: italic;">'
        + 'Generated at ' + now.toLocaleTimeString()
        + '</div>';

    document.getElementById("testDiv").innerHTML = myHTML;

}

function editPizza(event,PizzaId,PizzaName,Vegetarian,Vegan,GlutenFree) {

    const id = event.target.getAttribute("data-id");

    if (id === null) {

        document.getElementById("editHeading").innerHTML = 'Add new Pizza:';

        document.getElementById("PizzaId").value = '';
        document.getElementById("PizzaName").value = '';
        document.getElementById("Vegetarian").value = '';
        document.getElementById("Vegan").value = '';
        document.getElementById("GlutenFree").value = '';

        document.getElementById("listDiv").style.display = 'none';
        document.getElementById("editDiv").style.display = 'block';

    } else {
        fetch('/pizzas/get/' + id, {method: 'get'}
        ).then(response => response.json()
        ).then(fruit => {

            if (fruit.hasOwnProperty('error')) {
                alert(fruit.error);
            } else {

                document.getElementById("editHeading").innerHTML = 'Editing ' + fruit.name + ':';

                document.getElementById("PizzaId").value = PizzaId;
                document.getElementById("PizzaName").value = PizzaName;
                document.getElementById("Vegetarian").value = Vegetarian;
                document.getElementById("Vegan").value = Vegan;
                document.getElementById("GlutenFree").value = GlutenFree;

                document.getElementById("listDiv").style.display = 'none';
                document.getElementById("editDiv").style.display = 'block';

            }
        });
    }
}
function saveEditPizza(event){

    event.preventDefault();

    if (document.getElementById("PizzaName").value.trim() === '') {
        alert("Please provide a pizza name.");
        return;
    }

    if (document.getElementById("Vegetarian").value.trim() === '') {
        alert("Is this pizza vegetarian?.");
        return;
    }

    if (document.getElementById("Vegan").value.trim() === '') {
        alert("Is this pizza Vegan?.");
        return;
    }
    if (document.getElementById("GlutenFree").value.trim() === '') {
        alert("Is this pizza GlutenFree?.");
        return;
    }
    const id = document.getElementById("PizzaId").value;
    const form = document.getElementById("fruitForm");
    const formData = new FormData(form);

    let apiPath = '';
    if (id === '') {
        apiPath = '/pizzas/new';
    } else {
        apiPath = '/pizzas/update';
    }

    fetch(apiPath, {method: 'post', body: formData}
    ).then(response => response.json()
    ).then(responseData => {

        if (responseData.hasOwnProperty('error')) {
            alert(responseData.error);
        } else {
            document.getElementById("listDiv").style.display = 'block';
            document.getElementById("editDiv").style.display = 'none';
            pageLoadAdmin();
        }
    });
}
function cancelEditPizza(event) {

    event.preventDefault();

    document.getElementById("listDiv").style.display = 'block';
    document.getElementById("editDiv").style.display = 'none';

}
function deletePizza(event) {

    const ok = confirm("Are you sure?");

    if (ok === true) {

        let id = event.target.getAttribute("data-id");
        let formData = new FormData();
        formData.append("id", id);

        fetch('/pizzas/delete', {method: 'post', body: formData}
        ).then(response => response.json()
        ).then(responseData => {

                if (responseData.hasOwnProperty('error')) {
                    alert(responseData.error);
                } else {
                    pageLoadAdmin();
                }
            }
        );
    }
}




