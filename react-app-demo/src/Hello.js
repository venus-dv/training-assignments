import { useContext } from "react";
import ClickCounter from "./components/ClickCounterComponent";
import TextDisplayComponent from "./components/TextDisplayComponent";
import TextComponent from "./hoc/TextComponent";
import MyContext from "./components/contextDemo/MyContext";

const Hello  = (props) => {
    const theData = useContext(MyContext);
    return (
        <>
            <h2>Hello Functional Component</h2>
            <p>Hello World from Hello Component.... {props.name} --- {props.lastname}</p>
            <hr/>
            <TextComponent/>
            <hr/>
            <ClickCounter/>
            <hr/>
            <TextDisplayComponent/>
            <h2>Data from Context :::: {theData}</h2>
        </>
      );
}
 
export default Hello ;