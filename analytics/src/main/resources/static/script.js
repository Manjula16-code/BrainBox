let articleData = [], searchData = [], contributorData = [];
let articleChart, searchChart, contributorChart;

function toggleSection(id) {
    const section = document.getElementById(id);
    section.style.display = section.style.display === 'none' ? 'block' : 'none';
}

function toggleChart(canvasId, chartRef, renderChartFn) {
    const canvas = document.getElementById(canvasId);
    if (canvas.style.display === 'block') {
        canvas.style.display = 'none';
        if (chartRef) chartRef.destroy();
    } else {
        canvas.style.display = 'block';
        renderChartFn();
    }
}

function fetchArticleCounts() {
    fetch('/api/activity/article-action-count')
        .then(res => res.json())
        .then(data => {
            articleData = data;
            let html = "<table><tr><th>Article ID</th><th>Action</th><th>Count</th></tr>";
            data.forEach(item => {
                html += `<tr><td>${item.articleId}</td><td>${item.actionType}</td><td>${item.count}</td></tr>`;
            });
            html += "</table>";
            document.getElementById("articleCounts").innerHTML = html;
            document.getElementById("articleCounts").style.display = 'none';
        });
}

function fetchSearchStats() {
    fetch('/api/activity/popular-searches')
        .then(res => res.json())
        .then(data => {
            searchData = data;
            let html = "<table><tr><th>Search Query</th><th>Count</th></tr>";
            data.forEach(item => {
                html += `<tr><td>${item.searchQuery}</td><td>${item.count}</td></tr>`;
            });
            html += "</table>";
            document.getElementById("searchStats").innerHTML = html;
            document.getElementById("searchStats").style.display = 'none';
        });
}

function fetchContributorStats() {
    fetch('/api/activity/contributor-stats')
        .then(res => res.json())
        .then(data => {
            contributorData = data;
            let html = "<table><tr><th>User ID</th><th>Total Actions</th></tr>";
            data.forEach(item => {
                html += `<tr><td>${item.userId}</td><td>${item.totalActions}</td></tr>`;
            });
            html += "</table>";
            document.getElementById("contributorStats").innerHTML = html;
            document.getElementById("contributorStats").style.display = 'none';
        });
}

// Chart Generators
function generateArticleChart() {
    const ctx = document.getElementById("articleChart").getContext("2d");
    const labels = articleData.map(item => `${item.articleId} (${item.actionType})`);
    const counts = articleData.map(item => item.count);
    if (articleChart) articleChart.destroy();
    articleChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                label: 'Article Actions',
                data: counts,
                backgroundColor: '#FF1694'
            }]
        }
    });
}

function generateSearchChart() {
    const ctx = document.getElementById("searchChart").getContext("2d");
    const labels = searchData.map(item => item.searchQuery);
    const counts = searchData.map(item => item.count);
    if (searchChart) searchChart.destroy();
    searchChart = new Chart(ctx, {
        type: 'pie',
        data: {
            labels: labels,
            datasets: [{
                data: counts,
                backgroundColor: ['#FF6384', '#36A2EB', '#FFCE56', '#4BC0C0']
            }]
        }
    });
}

function generateContributorChart() {
    const ctx = document.getElementById("contributorChart").getContext("2d");
    const labels = contributorData.map(item => item.userId);
    const counts = contributorData.map(item => item.totalActions);
    if (contributorChart) contributorChart.destroy();
    contributorChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: labels,
            datasets: [{
                label: 'Contributions',
                data: counts,
                borderColor: '#1520A6',
                backgroundColor: 'transparent',
                fill: false,
                pointBackgroundColor: '#f0f0f0'
            }]
        }
    });
}

// Load data on page load and hide sections initially
 document.addEventListener("DOMContentLoaded", () => {
     fetchArticleCounts();
     fetchSearchStats();
     fetchContributorStats();

     document.getElementById("articleCounts").style.display = 'none';
     document.getElementById("searchStats").style.display = 'none';
     document.getElementById("contributorStats").style.display = 'none';
 });

