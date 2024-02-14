import './index.css';
import CourseTitleBox from './CourseTitleBox';

const CourseListing = ({ courseName, courseCode, numReviews, offerings}) => {
    return <div class="course-box">
        <CourseTitleBox courseCode={courseCode} numReviews={numReviews}/>

        <div class="name-box">
            <p class="course-name">{courseName}</p>
        </div>
        
        <div class="term-box">
            {offerings.map((term, index) => (
                <p key={index} className="term-bubble">
                    {term}
                </p>
            ))}
        </div>
    </div>
}

export default CourseListing