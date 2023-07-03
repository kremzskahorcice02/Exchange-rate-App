import { useState } from "react";
import RateDetails from "./RateDetails";

const RatesList = (props) => {
    const rates = props.rates;
    const [rate, setRate] = useState(rates[0]);

    const handleDetails = (rateId) => {
        setRate(rates.find((rate) => rate.id === rateId));
    } 

    return (
        <div className="rates">
            <ul>
                {rates.map(rate => (
                    <li key={rate.id} onClick={() => handleDetails(rate.id)}>{rate.country}</li>
                ))}
            </ul>
            <RateDetails rate={rate}/>
        </div>
    );
}

export default RatesList;