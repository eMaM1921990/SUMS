/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getType(type) {

    switch (parseInt(type)) {

        case 1:
            $('#type').html(Student());
            break;

        case 2:
            $('#type').html(External());
            break;
        default :
            break;

    }



}

function Student() {
    var buffer = "<div class=\"form-group\">"
            + "<div class=\"input-icon right\">"
            + "<span class=\"fa fa-repeat text-gray\"></span>"
            + "<input type=\"text\" class=\"form-control\" placeholder=\"HEMIS/Jupiter\" id=\"HEMIS\">"
            + "</div>"
            + "</div>";

    return buffer;
}

function External() {
    var row = "<div class=\"form-group\">"
            + "<div class=\"input-icon right\">"
            + "<span class=\"fa fa-repeat text-gray\"></span>"
            + "<input type=\"text\" class=\"form-control\" placeholder=\"Oraginzation name\" id=\"Name\">"
            + "</div>"
            + "</div>";

    var row2 = "<div class=\"form-group\">"
            + "<div class=\"input-icon right\">"
            + "<span class=\"fa fa-repeat text-gray\"></span>"
            + "<input type=\"text\" class=\"form-control\" placeholder=\"Postal Address\" id=\"Postal Address\">"
            + "</div>"
            + "</div>";

    var row3 = "<div class=\"form-group\">"
            + "<div class=\"input-icon right\">"
            + "<span class=\"fa fa-repeat text-gray\"></span>"
            + "<input type=\"text\" class=\"form-control\" placeholder=\"Postal Code\" id=\"Postal code\">"
            + "</div>"
            + "</div>";

    var row4 = "<div class=\"form-group\">"
            + "<div class=\"input-icon right\">"
            + "<span class=\"fa fa-repeat text-gray\"></span>"
            + "<input type=\"text\" class=\"form-control\" placeholder=\"Activity Description\" id=\"Activity description\">"
            + "</div>"
            + "</div>";

    var buffer = row + row2 + row3 + row4;

    return buffer;
}

function Reg_Validation() {
    if (document.getElementById("Forename").value === "") {
        document.getElementById("notification").innerHTML = "Please enter Forename";
        return false;
    } else {
        document.getElementById("notification").innerHTML = "";
    }

    if (document.getElementById("Surname").value === "") {
        document.getElementById("notification").innerHTML = "Please enter SureName";
        return false;
    } else {
        document.getElementById("notification").innerHTML = "";
    }

    if (document.getElementById("Email").value === "") {
        document.getElementById("notification").innerHTML = "Please enter Email";
        return false;
    } else {
        document.getElementById("notification").innerHTML = "";
    }

    if (document.getElementById("Username").value === "") {
        document.getElementById("notification").innerHTML = "Please enter Username";
        return false;
    } else {
        document.getElementById("notification").innerHTML = "";
    }

    if (document.getElementById("Password").value === "") {
        document.getElementById("notification").innerHTML = "Please enter Password";
        return false;
    } else {
        document.getElementById("notification").innerHTML = "";
    }

    if (document.getElementById("repass").value === "") {
        document.getElementById("notification").innerHTML = "Please enter RePassword";
        return false;
    } else {
        document.getElementById("notification").innerHTML = "";
    }

    if (document.getElementById("types").value === "1") {
        if (document.getElementById("HEMIS").value === "") {
            document.getElementById("notification").innerHTML = "Please enter HEMIS";
            return false;
        } else {
            document.getElementById("notification").innerHTML = "";
        }
    } else {
        if (document.getElementById("Name").value === "") {
            document.getElementById("notification").innerHTML = "Please enter Oraginzation name";
            return false;
        } else {
            document.getElementById("notification").innerHTML = "";
        }

        if (document.getElementById("Postal Address").value === "") {
            document.getElementById("notification").innerHTML = "Please enter Oraginzation Postal Address";
            return false;
        } else {
            document.getElementById("notification").innerHTML = "";
        }

        if (document.getElementById("Postal code").value === "") {
            document.getElementById("notification").innerHTML = "Please enter Postal code";
            return false;
        } else {
            document.getElementById("notification").innerHTML = "";
        }

        if (document.getElementById("Activity description").value === "") {
            document.getElementById("notification").innerHTML = "Please enter Activity description";
            return false;
        } else {
            document.getElementById("notification").innerHTML = "";
        }

    }


    if (document.getElementById("phone").value === "") {
        document.getElementById("notification").innerHTML = "Please enter phone";
        return false;
    } else {
        document.getElementById("notification").innerHTML = "";
    }

    return true;
}

function Resgistration() {
    
    if(Reg_Validation()===true){
        var Forename=$('#Forename').val();
        var Surname=$('#Surname').val();
        var Username=$('#Username').val();
        var Password=$('#Password').val();
        var PERSON_STATUSID=$('#types').val();
        var HEMIS=$('#HEMIS').val();
        var Name=$('#Name').val();
        var Postal_Address=$('#Postal Address').val();
        var Post_code=$('#Post code').val();
        var Activity_description=$('#Activity description').val();
        var phone=$('#phone').val();
        var mail=$('#Email').val();
        $.post('Registration',
        {Forename:Forename,
            Surname:Surname,
            Username:Username,
            Password:Password,
            PERSON_STATUSID:PERSON_STATUSID,
            HEMIS:HEMIS,
            Name:Name,
            Postal_Address:Postal_Address,
            Post_code:Post_code,
            Activity_description:Activity_description,
            phone:phone,
            mail:mail
            
            
        },function (responseText){
            document.getElementById("notification").innerHTML = responseText;
        });
    }
}


function changePassword(fromsession,user_val,newval){
    
    if(getCurrentPassword(fromsession,user_val)===true){
        document.getElementById('change').innerHTML="Change Password";
        $.post('ChangePassword',{pass:newval},function(responseText){
            document.getElementById('change').innerHTML="Change Password"+"<b style='color:green'>... "+responseText+" </b>";
            document.getElementById('cancel').click();
        });
    }else{
        document.getElementById('change').innerHTML="Change Password"+"<b style='color:red'>... Wrong password </b>";
        //document.getElementById('change').style.color='red';
    }
}


function getCurrentPassword(fromsession,user_val){
    if(fromsession.trim()===user_val.trim()){
        return true;
    }else{
        return false;
    }
}


function validationUpdatePersonalInfo(forname,surname){
    if(forname.trim()===''){
        
    }else{
        
    }
    
    
}