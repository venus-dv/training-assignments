import { fireEvent, render, screen } from "@testing-library/react"
import Counter from "./Counter"

describe('Testing the Counter', ()=>{

test('Testing the Increment Counter', ()=>{
    // render the component to test
    render(<Counter/>)

    // select the elements you want to interact with
    const counter = screen.getByTestId("counter");
    const incrementButton = screen.getByTestId("increment");

    // interact with the elements
    fireEvent.click(incrementButton);

    // assert the expected result
    expect(counter).toHaveTextContent("1");
})

test('Testing the Decrement Counter', ()=>{
    // render the component to test
    render(<Counter/>)

    // select the elements you want to interact with
    const counter = screen.getByTestId("counter");
    const decrementButton = screen.getByTestId("decrement");

    // interact with the elements
    fireEvent.click(decrementButton);

    // assert the expected result
    expect(counter).toHaveTextContent("-1");
})
});