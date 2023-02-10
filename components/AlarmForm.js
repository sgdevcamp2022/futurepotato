import { useSelector } from "react-redux";

const AlarmForm = () => {
    const {alarmData} = useSelector((state) =>state.mainpage);
    return(
        <div className="flex-center">
            <div className="modal_window_option">
                <div className="follwing-title">알람</div>
                <div className="Follow_ing_list">
                    {alarmData.map((v, index) => (
                        <div className="follow-wrapper">
                            <div key={index}>{v.actionMessage}</div>
                        </div>
                    ))}
                </div>    
            </div>
        </div>
    );
}


export default AlarmForm;