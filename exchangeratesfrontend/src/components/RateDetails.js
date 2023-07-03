const RateDetails = (props) => {
    const rate = props.rate;
    return ( 
        <table>
            <tbody>
                {Object.keys(rate).map(key => {
                    
                    if (key !== "id") {
                        return (
                            <tr key={key}>
                                <th>{key}:</th>
                                <td>{rate[key]}</td>
                            </tr>
                        );
                    }
                })}
            </tbody>
        </table>
     );
}
 
export default RateDetails;