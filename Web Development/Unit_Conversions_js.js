function temperature(){
    //To convert celcius to farenheit
    //(CEL * 9/5) + 32
    var c = document.getElementById("c").value;
    var f = document.getElementById("f").value;
    if(c == "" && f == "") {
        alert("Both fahrenheit and celsius fields are empty");
    } else if(c == "" && f != "") {
        var c = (f - 32) / (9/5);
        document.getElementById("c").value = c;
    } else {
        var f = (c * 9/5) + 32;
        document.getElementById("f").value = f;
    }
}

function weight(){
    //To convert KGs to Pounds
    // KG * 2.2
    var kg = document.getElementById("kg").value;
    var p = document.getElementById("lbs").value;
    if(kg == "" && p == "") {
        alert("Both kilogram and pound fields are empty");
    } else if(kg == "" && p != "") {
        kg = p / 2.2;
        document.getElementById("kg").value = kg;
    } else {
        var p = kg * 2.2;
        document.getElementById("lbs").value = p;
    }
}

function distance(){
    //To convert KMs to Miles
    // KM * 0.62137
    var km = document.getElementById("km").value;
    var m = document.getElementById("m").value;
    if(kg == "" && p == "") {
        alert("Both kilometer and mile fields are empty");
    } else if(km == "" && m != "") {
        km = m / 0.62137;
        document.getElementById("km").value = km;
    } else {
        m = km * 0.62137
        document.getElementById("m").value = m;
    }
}