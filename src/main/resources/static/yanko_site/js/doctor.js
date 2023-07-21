fetch('/doctors')
    .then(response => response.json())
    .then(doctors => {
        const selectElement = document.getElementById('doctorSelect');
        doctors.forEach(doctor => {
            const option = document.createElement('option');
            option.value = doctor.id;
            option.textContent = doctor.name;
            selectElement.appendChild(option);
        });
    });