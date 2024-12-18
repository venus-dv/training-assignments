import withFancyText from "./withFancyText";

const TextComponent = () => {
    return ( 
        <p>Hello Fancy Text.</p>
     );
}
 
export default withFancyText(TextComponent);