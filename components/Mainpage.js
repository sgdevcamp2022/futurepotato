import AppLayout from "./AppLayout";
import StoryForm from "./Story/StoryForm";
import MainPosts from "./Mainpost/MainPosts";
import Recommend from "./MainSide/Recommend";
const Mainpage = () => {
    return(
        <>
        <AppLayout/>
        <section className="main">
            <div className="wrapper">
                <div className="left-col">
                    <StoryForm />
                    <MainPosts />
                </div>
                <div className="right-col">
                    <Recommend />
                </div>
            </div>
        </section>
        </>
    );
}

export default Mainpage;