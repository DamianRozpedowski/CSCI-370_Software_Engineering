# Android Development - Tip Calculator

This is a basic tip calulator app developed on Android Studio using Java with a minimum API level of 26.

## How to use the app

The use of this app is fairly straightforward here are the steps,
1. Launch the app through an android supported device/emulator.
2. Enter the check amount followed by the party amount (amount of people splitting the bill).
3. Click on the "COMPUTE BILL" button for the application to calculate the amount owed per person.

# The results

When you finished computing the bill you will be given the calculations back, you will see the tip amount owed per person based on 15%,20%, and 25%. The total amount will also be displayed, this shows the total amount thats owed per person with the tip included, it again depends on a 15%,20%, or 25% tip.

#Errors
There are some errors that are handled, 
1. When no value is entered but the button is pressed, it will be handled through Toast and will display an error message  prompting the user to enter the correct values.
2. When the check amount is less than 0 or the party size is less than 1, Toast will also handle this and display an error message prompting the user to enter the correct values.
