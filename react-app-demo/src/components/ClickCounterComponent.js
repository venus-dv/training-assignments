import React, { useRef } from 'react';

const ClickCounter = () => {
    const clickCountRef = useRef(0);

    const handleClick = () => {
        clickCountRef.current += 1;
        alert(`Button clicked ${clickCountRef.current} times`);
    };

    return (
        <div>
            <button onClick={handleClick}>Click Me</button>
        </div>
    );
};

export default ClickCounter;
