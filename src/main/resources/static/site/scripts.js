// Function to fetch and display the JSON data
function fetchAndDisplayJson() {
    fetch('/products') // Replace '/api/data' with the actual URL of your backend endpoint that serves the JSON data
        .then(response => response.json())
        .then(data => displayJsonData(data))
        .catch(error => console.error('Error fetching JSON:', error));
}

// Function to display the JSON data on the page
function displayJsonData(data) {
    const jsonContainer = document.getElementById('json-container');
    jsonContainer.innerHTML = JSON.stringify(data, null, 2);
}

// Call the fetchAndDisplayJson function when the page loads
document.addEventListener('DOMContentLoaded', fetchAndDisplayJson);