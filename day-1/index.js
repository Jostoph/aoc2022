const nReadlines = require('n-readlines');

function getMaxCalories(fileName) {
    const inputFile = new nReadlines(fileName);

    let maxCalories = 0;
    let line;

    let caloriesBuffer = 0;
    console.log(`reading ${fileName}:`);

    do {
        line = inputFile.next();
        if (line === false || line.length === 0) {
            if (caloriesBuffer > maxCalories) {
                maxCalories = caloriesBuffer;
            }
            caloriesBuffer = 0;
        } else {
            caloriesBuffer += +line.toString('ascii');
        }
    } while (line);

    console.log(`max calories is: ${maxCalories}`);
    return maxCalories;
}

function getSumTop3Calories(fileName) {
    const inputFile = new nReadlines(fileName);

    let top3 = [];
    let line;

    let caloriesBuffer = 0;
    console.log(`reading ${fileName}:`);
    do {
        line = inputFile.next();
        if (line === false || line.length === 0) {
            top3.push(caloriesBuffer);
            top3.sort((a, b) => b - a);
            top3 = top3.slice(0, 3);
            caloriesBuffer = 0;
        } else {
            caloriesBuffer += +line.toString('ascii');
        }
    } while (line);

    console.log(`top 3 :`);
    top3.forEach((v, i) => console.log(`${i + 1}: ${v}`));
    const total = top3.reduce((acc, curr) => acc + curr, 0);
    console.log(`total is ${total}`);
    return total;
}

function testPart1() {
    const expected = 24000;
    const maxCal = getMaxCalories('test_input.txt');
    console.log(`Expected ${expected}, got ${maxCal} - ${expected === maxCal? 'Passed': 'Failed'}`);
}

function testPart2() {
    const expected = 45000;
    const total = getSumTop3Calories('test_input.txt');
    console.log(`Expected ${expected}, got ${total} - ${expected === total? 'Passed': 'Failed'}`);
}

function main() {
    // testPart1();
    // getMaxCalories('input.txt');
    // testPart2();
    getSumTop3Calories('input.txt');
}

if (require.main === module) {
    main();
}