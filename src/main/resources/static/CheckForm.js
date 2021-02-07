function checkForm(form) {
    // validation fails if the input is blank
    if (form.itemAdd.value === "") {
        alert("Count Empty");
        form.itemAdd.focus();
        return false;
    }
    var re = /^[\w ]+$/;
    if (!re.test(form.itemAdd.value)) {
        alert("Nope");
        form.itemAdd.focus();
        return false;
    }
    return true;
}