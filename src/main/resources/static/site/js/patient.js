fetch('/patients/1')
    .then(response => response.json())
    .then(patient => {
        document.getElementById('owner_name').value = patient.ownerName;
        document.getElementById('name').value = patient.name;
        document.getElementById('species').value = patient.species;
        document.getElementById('breed').value = patient.breed;
        document.getElementById('allergies').value = patient.allergies;
        document.getElementById('owner_contact').value = patient.ownerContact;

    })
    .catch(error => {
        console.error('Error fetching patient data:', error);
    });