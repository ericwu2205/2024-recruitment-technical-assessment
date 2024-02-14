import './index.css';

const CourseTitleBox = ({ courseCode, numReviews }) => {
    return <div class="course-title-box"> 
        <p class="course-code">{courseCode}</p>
        <div class="rating-box">
            <p class="star-box">★★★★★</p>
            <p class="review-count">{numReviews} reviews</p>
        </div>
    </div>
}

export default CourseTitleBox