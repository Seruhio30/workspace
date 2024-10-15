document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('form');

    form.addEventListener('submit', function(event) {
        const nameInput = document.getElementById('name');
        const priceInput = document.getElementById('price');

        if (!nameInput.value || priceInput.value <= 0) {
            alert('Please provide valid name and price.');
            event.preventDefault();
        }
    });
});
