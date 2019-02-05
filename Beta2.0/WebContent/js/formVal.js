/**
 * 
 */
function oraORempty(uora){
	var letters= /^[0-2][0-9]\.[0-5][0-9]$|^$/;  //stringa vuota o double (es= 12.30)
    return validateField(uora,letters);
    }

function allLetterORempty(uname1)  {   
	var letters = /^[A-Za-z]+$|^$/; 
	return validateField(uname1, letters); 
}

function alphanumericORempty(uadd1)  
{   
	var letters = /^[0-9a-zA-Z]+$|^/;  
	return validateField(uadd1, letters);
}

function allLetter(uname)  
{   
	var letters = /^[A-Za-z]+$/; 
	return validateField(uname, letters); 
}

function alphanumeric(uadd)  
{   
	var letters = /^[0-9a-zA-Z]+$/;  
	return validateField(uadd, letters);
}

function numeric(uadd)  
{   
	var letters = /^[0-9]+$/;  
	return validateField(uadd, letters);
}

function validateEmail(uemail)  
{  
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
	return validateField(uemail, mailformat);
}

function validateCF(code)  
{  
    var codeformat = /^[A-Z]{6}\d{2}[A-Z]\d{2}[A-Z]\d{3}[A-Z]$/i;  
	return validateField(code, codeformat );
}

function validateField(field, format)  
{  
    if(field.value.match(format))  
		return true;  
    else  
		return false;
}

function vuota(uv){
var letters=/^$/;
return validateField(uV,letters);
}

function isEmpty(field){
    if(field.value.length <= 0)  
		return true;  
    else  
		return false;
}

function clearForm(form){
	//reset input border color
	var inputs = form.getElementsByTagName("input");
	for(var i = 0; i<inputs.length; i++)
		inputs[i].style.borderColor = "black"; 
	
	//delete previous error messages
	var spans = form.getElementsByTagName("span");
	for(var i = 0; i<spans.length; i++)
		form.removeChild(spans[i]);
}


