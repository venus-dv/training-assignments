import React, { useRef } from 'react';

const TextDisplayComponent = () => {
    const inputRef = useRef(null);
    const paragraphRef = useRef(null);

    const handleChange = () => {
        paragraphRef.current.textContent = inputRef.current.value;
    };

    return (
        <div>
            <input type="text" ref={inputRef} onChange={handleChange} placeholder="Type something..." 
            />
            <p ref={paragraphRef}></p>
        </div>
    );
};

export default TextDisplayComponent;

