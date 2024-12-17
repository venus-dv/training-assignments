import React, { useState } from 'react';

const Counter = () => {
    const [counter, setCounter] = useState(0);

    const handleIncrement = () => {
        setCounter(counter + 1);
    };

    const handleDecrement = () => {
        setCounter(counter - 1);
    };

    return ( 
        <>
            <button data-testid = "increment" onClick={handleIncrement}>Increment</button>
            <h3 data-testid = "counter">{counter}</h3>
            <button data-testid = "decrement" onClick={handleDecrement}>Decrement</button>
        </>
    );
}
 
export default Counter;
