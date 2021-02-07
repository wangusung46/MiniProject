function allnumeric(inputtxt) {
    var numbers = /^[0-9]+$/;
    var r = confirm("Apakah Anda Akan Menyimpan Data Ini");
    if (r === true) {
        if (inputtxt.value.match(numbers)) {
            return true;
        }else{
            alert('Masukan Nomor Saja');
        return false;
        }
    } else {
        return false;
    }
} 