import './index.css';

const SearchBox = () => {
    return <div id="search-box"> 
        <div id="search-bar">
            <svg id="magnifying-icon" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                <path stroke-linecap="round" stroke-linejoin="round" d="m21 21-5.197-5.197m0 0A7.5 7.5 0 1 0 5.196 5.196a7.5 7.5 0 0 0 10.607 10.607Z" />
            </svg>                      
            <input type="search" id="query" name="q" placeholder="Search for a course e.g. COMP1511"/>
        </div>

        <select id="filter-by-bar">
            <option value="0">Sort by</option>
            <option value="1">Alphabetical (A-Z)</option>
            <option value="2">Alphabetical (Z-A)</option>
            <option value="3">Overall Rating</option>
            <option value="4">Enjoyability</option>
            <option value="5">Usefulness</option>
            <option value="6">Manageability</option>
        </select>
    </div>
}

export default SearchBox