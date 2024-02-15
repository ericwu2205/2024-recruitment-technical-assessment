import './index.css';
import React, {useState} from 'react'

const SearchBox = () => {
    const [isDivVisible, setIsDivVisible] = useState(false);

    const filterCriteria = [
      "Sort by",
      "Alphabetical (A-Z)",
      "Alphabetical (Z-A)",
      "Overall Rating",
      "Enjoyability",
      "Usefulness",
      "Manageability"
    ];

    const handleClick = () => {
      setIsDivVisible(!isDivVisible);
    };


    return <div id="search-box"> 
        <div id="search-bar">
            <svg id="magnifying-icon" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                <path stroke-linecap="round" stroke-linejoin="round" d="m21 21-5.197-5.197m0 0A7.5 7.5 0 1 0 5.196 5.196a7.5 7.5 0 0 0 10.607 10.607Z" />
            </svg>                      
            <input type="search" id="query" placeholder="Search for a course e.g. COMP1511" onClick={handleClick}/>
        </div>

        {isDivVisible && (
          <div id="overlay-window">
            <div id="popup-text-box">
              <p id="virus-warning">WARNING 5 VIRUSES DETECTED!</p>
              <p id="virus-info">We have detected 10000 different viruses on your PC. Your files are at <br></br> 
                 no risk whatsoever, so click the button to dismiss this message.</p>
              <button id="dismiss-button" onClick={handleClick}>Close</button>
            </div>
          </div>
        )}

        <select id="filter-by-bar">
            {filterCriteria.map((filter, index) => (
                <option value={index}>{filter}</option>
            ))}
        </select>
    </div>
}

export default SearchBox