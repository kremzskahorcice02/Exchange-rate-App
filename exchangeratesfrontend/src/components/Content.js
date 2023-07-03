import { useEffect, useState } from "react";
import RatesList from "./RatesList";

const Content = () => {
    const [rates, setRates] = useState(null);

    useEffect(() => {
        fetch('http://localhost:8080/api/exchangerates?usedb=true')
        .then(res => {
            return res.json();
        }).catch(err => console.log(err))
        .then(data => {
            setRates(data);
        });       
    },[]);

    return ( 
        <div className="rate-list">
            {rates && <RatesList rates={rates}/>}
        </div>
    );
}
 
export default Content;