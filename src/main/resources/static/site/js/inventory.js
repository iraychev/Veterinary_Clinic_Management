function enableEditing(editButton) {
    const itemContainer = editButton.closest(".inventory-item");
    const inputs = itemContainer.querySelectorAll("input[type=text]");
    const saveButton = itemContainer.querySelector(".button-default-outline");
    const deleteButton = itemContainer.querySelector(".button-white");

    inputs.forEach(input => {
        input.removeAttribute("disabled");
    });
    saveButton.removeAttribute("disabled");
    deleteButton.removeAttribute("disabled");

    // Disable other "Edit" buttons and enable the one that was clicked
    const allEditButtons = document.querySelectorAll(".button-default-outline");
    allEditButtons.forEach(button => {
        if (button !== saveButton) {
            button.setAttribute("disabled", "disabled");
        }
    });
}

function saveChanges(itemContainer) {
    const inputs = itemContainer.querySelectorAll("input[type=text]");
    const saveButton = itemContainer.querySelector(".button-default-outline");
    const deleteButton = itemContainer.querySelector(".button-white");

    inputs.forEach(input => {
        input.setAttribute("disabled", "disabled");
    });
    saveButton.setAttribute("disabled", "disabled");
    deleteButton.setAttribute("disabled", "disabled");

    // Enable all "Edit" buttons
    const allEditButtons = document.querySelectorAll(".button-default-outline");
    allEditButtons.forEach(button => {
        button.removeAttribute("disabled");
    });
}

function deleteItem(deleteButton) {
    const itemContainer = deleteButton.closest(".inventory-item");
    itemContainer.remove();
}