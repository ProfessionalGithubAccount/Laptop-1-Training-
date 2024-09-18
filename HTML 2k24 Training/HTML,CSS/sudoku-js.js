// Function to clear all input fields in the Sudoku grid
function clearGrid() {
    // Get all input elements with the class 'sudoku-cell'
    console.log("kkk");
    const cells = document.querySelectorAll(".sudoku-cell");
    
    // Iterate over each cell and clear its value
    cells.forEach(cell => cell.value = '');
}

// Function to handle Sudoku solving (currently a placeholder)
function solveSudoku() {
    // Collect all input values
    const cells = document.querySelectorAll('.sudoku-cell');
    
    // For now, just log the values to the console
    let board = [];
    
    cells.forEach(cell => {
        board.push(cell.value ? cell.value : ''); // Collect values or empty strings
    });
    
    console.log('Current board values:', board);
    
    // You can implement the Sudoku solving logic here
    // For now, we will just simulate solving by filling in some default values
    
    // Example of filling in some values (this is just a placeholder)
    cells.forEach((cell, index) => {
        if (cell.value === '') {
            cell.value = (index % 9) + 1; // Fill with dummy values
        }
    });
}
