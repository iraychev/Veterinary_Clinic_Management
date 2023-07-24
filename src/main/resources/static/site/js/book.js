
function formatDateForServer(dateString, timeString) {
    const [year, month, day] = dateString.split('-'); // Assuming the date is in "yyyy-MM-dd" format
    const [hours, minutes] = timeString.split(':'); // Assuming the time is in "HH:mm" format
    return `${year}-${month}-${day}T${hours}:${minutes}:00`;
}
let ownerCounter = 1;
function bookAppointment() {
    const appointmentDate = document.getElementById('appointment_date').value;
    const appointmentTime = document.getElementById('appointment_time').value;
    const ownerId = ownerCounter++;
    const doctorId = document.getElementById('doctorSelect').value;
    const remarks = document.getElementById('remarks').value;
    const durationMinutes = "60"; // Default duration time set to 1 hour

    // Combine the date and time inputs into a single appointmentDateTime field
    const appointmentDateTime = formatDateForServer(appointmentDate, appointmentTime);



    const appointmentData = {

        doctor: {
            id: parseInt(doctorId)
        },
        patient: {
            id: parseInt(ownerId)
        },
        appointmentDate: appointmentDateTime,
        durationMinutes: durationMinutes,
        remarks: remarks
    };

    // Send the appointmentData to the backend for saving the appointment
    fetch('/appointments', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(appointmentData)
    })
        .then(response => {
            if (response.ok) {
                alert('Appointment booked successfully!');
                console.log(appointmentData);

            } else {
                response.json().then(data => {
                    console.error('Error:', data.error);
                    alert('An error occurred while booking the appointment: ' + data.error);
                    console.log(appointmentData);
                });
            }
        })
        .catch(error => {
            // Handle any errors that occurred during the request
            console.error('Error:', error);
            alert('An error occurred while booking the appointment. Please try again.');
            console.log(appointmentData);
        });


}
fetch('/patients/1')
    .then(response => response.json())
    .then(patient => {
        document.getElementById('owner_name').value = patient.ownerName;
        document.getElementById('patient').value = patient.name;
        document.getElementById('species').value = patient.species;
        document.getElementById('breed').value = patient.breed;
        document.getElementById('allergies').value = patient.allergies;
        document.getElementById('owner_contact').value = patient.ownerContact;
    })
    .catch(error => {
        console.error('Error fetching patient data:', error);
    });

// Fetch and populate the list of doctors in the "Select Doctor" dropdown
fetch('/doctors')
    .then(response => response.json())
    .then(doctors => {
        const doctorSelect = document.getElementById('doctorSelect');
        doctors.forEach(doctor => {
            const option = document.createElement('option');
            option.value = doctor.id;
            option.textContent = doctor.name;
            doctorSelect.appendChild(option);
        });
    })
    .catch(error => {
        console.error('Error fetching doctors:', error);
        alert('Error fetching doctors. Please try again later.');
    });