function pageLoadIndex() {

    let now = new Date();

    let myHTML = '<div style="text-align:Left;">'
        + '<button>Home</button>'
        + '<button>Checkout</button>'
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

function pageLoadCheckout() {

    let now = new Date();

    let myHTML = '<div style="text-align:Left;">'
        + '<button>Home</button>'
        + '<button>Checkout</button>'
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
