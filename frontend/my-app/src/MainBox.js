import CourseListing from './CourseListing';
import './index.css';
import SearchBox from './SearchBox';
import data from './courses.json';
import { useState } from 'react'

const MainBox = () => {
    const [color, setColor] = useState('#3877EA');

    const changeColor = () => {
    setColor(color === '#3877EA' ? 'black' : '#3877EA');
    };

    return <div id="main-box">
        <div class="filler-box"></div>
        <div id="heading-box">
            <p id="soc-heading">DevSoc presents</p>
            <h2 id="bold-blue-heading" onClick={changeColor} style={{color}}>unilectives</h2>
            <h3 id="bold-heading">Your one-stop shop for UNSW course and elective reviews.</h3>
        </div>

        <SearchBox/>

        <div id="course-listing-box">
            {data.map((course) => (
                <CourseListing courseName={course.course_title} courseCode={course.course_prefix + course.course_code} numReviews={course.total_reviews} offerings={course.offered_terms} />
            ))}
        </div>

    </div>
}

export default MainBox