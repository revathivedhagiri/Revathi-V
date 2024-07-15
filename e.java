let courses = [
    { id: 1, title: 'Introduction to Programming', enrolled: false, progress: 0 },
    { id: 2, title: 'Web Development Basics', enrolled: false, progress: 0 },
    { id: 3, title: 'Data Science Fundamentals', enrolled: false, progress: 0 }
];

// Function to display courses
function displayCourses() {
    let coursesList = document.createElement('ul');
    courses.forEach(course => {
        let listItem = document.createElement('li');
        listItem.innerHTML = `
            <h3>${course.title}</h3>
            <p>Progress: ${course.progress}%</p>
            <button onclick="enroll(${course.id})">${course.enrolled ? 'Continue' : 'Enroll'}</button>
        `;
        coursesList.appendChild(listItem);
    });
    document.querySelector('main').appendChild(coursesList);
}

// Function to enroll in a course
function enroll(courseId) {
    let course = courses.find(c => c.id === courseId);
    if (course) {
        if (!course.enrolled) {
            course.enrolled = true;
            // Simulate progress tracking
            setInterval(() => {
                if (course.progress < 100) {
                    course.progress += 10;
                }
            }, 1000);
        }
        displayCourses(); // Refresh course list
    }
}

// Display courses initially
displayCourses();