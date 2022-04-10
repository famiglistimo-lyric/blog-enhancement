// Selectors
const player = document.getElementById('player');
const playBtn = document.getElementById('playBtn');
const title = document.getElementById('title');
const songImg = document.getElementById('songImg');
const progress = document.getElementById('progress');
const progressContainer = document.getElementById('progressContainer');

let index = 0;
const songs = [
    {
        title: '你会成为你想的那个人 - 梁博',
        file: 'https://yi-blog.oss-cn-hangzhou.aliyuncs.com/music/%E4%BD%A0%E4%BC%9A%E6%88%90%E4%B8%BA%E4%BD%A0%E6%83%B3%E6%88%90%E4%B8%BA%E7%9A%84%E9%82%A3%E4%B8%AA%E4%BA%BA%20-%20%E6%A2%81%E5%8D%9A/%E6%A2%81%E5%8D%9A-%E4%BD%A0%E4%BC%9A%E6%88%90%E4%B8%BA%E4%BD%A0%E6%83%B3%E7%9A%84%E9%82%A3%E4%B8%AA%E4%BA%BA%28Live%29.mp3',
        img: 'https://yi-blog.oss-cn-hangzhou.aliyuncs.com/music/%E4%BD%A0%E4%BC%9A%E6%88%90%E4%B8%BA%E4%BD%A0%E6%83%B3%E6%88%90%E4%B8%BA%E7%9A%84%E9%82%A3%E4%B8%AA%E4%BA%BA%20-%20%E6%A2%81%E5%8D%9A/dcd7807c7614ca099997e06b745023f.png'
    },
    {
        title: 'I still believe ~ため息~ - 滴草由实',
        file: 'https://yi-blog.oss-cn-hangzhou.aliyuncs.com/music/I%20still%20believe%20%7E%E3%81%9F%E3%82%81%E6%81%AF%7E/C400001cuBae3wvL59.m4a',
        img: 'https://yi-blog.oss-cn-hangzhou.aliyuncs.com/music/I%20still%20believe%20%7E%E3%81%9F%E3%82%81%E6%81%AF%7E/1649497172%281%29.jpg'
    },
    {
        title: '两相欢 - 音阙诗听/昆玉',
        file: 'https://yi-blog.oss-cn-hangzhou.aliyuncs.com/music/%E4%B8%A4%E7%9B%B8%E6%AC%A2/C4000001WdVU104ONO.m4a',
        img: 'https://yi-blog.oss-cn-hangzhou.aliyuncs.com/music/%E4%B8%A4%E7%9B%B8%E6%AC%A2/1649499351%281%29.jpg'
    },
    {
        title: 'Drunk Groove - MARUV/BOOSIN',
        file: 'https://yi-blog.oss-cn-hangzhou.aliyuncs.com/music/Drunk%20Groove/510e_065b_0f53_fdd1cc57901104e85d24897bb993efae.mp3',
        img: 'https://yi-blog.oss-cn-hangzhou.aliyuncs.com/music/Drunk%20Groove/1649498448%281%29.jpg'
    },
    {
        title: '願い～あの頃のキミへ～ - 當山みれい',
        file: 'https://yi-blog.oss-cn-hangzhou.aliyuncs.com/music/%E9%A1%98%E3%81%84%EF%BD%9E%E3%81%82%E3%81%AE%E9%A0%83%E3%81%AE%E3%82%AD%E3%83%9F%E3%81%B8%EF%BD%9E/obj_wo3DlMOGwrbDjj7DisKw_4278302986_c0e5_c0ba_d333_9bd02e06b1fdc1b4719d0f5f730612c1.mp3',
        img: 'https://yi-blog.oss-cn-hangzhou.aliyuncs.com/music/%E9%A1%98%E3%81%84%EF%BD%9E%E3%81%82%E3%81%AE%E9%A0%83%E3%81%AE%E3%82%AD%E3%83%9F%E3%81%B8%EF%BD%9E/1649498880%281%29.jpg'
    }]
const NUMBER_OF_SONGS = songs.length;

// Functions
const togglePlay = () => {
    playBtn.classList.contains('pause') ?
        player.pause() :
        player.play();

    playBtn.classList.toggle('pause');
}

const forcePlay = () => {
    if (!playBtn.classList.contains('pause'))
        playBtn.classList.add('pause')
    player.play();
}

const setSong = (newIndex) => {
    index = newIndex;
    if (newIndex >= NUMBER_OF_SONGS)
        index = 0;
    if (newIndex < 0)
        index = NUMBER_OF_SONGS - 1;

    // songImg.src = songs[index].img;
    player.src = songs[index].file;
    title.innerHTML = songs[index].title;
    forcePlay()
}

const setProgress = (e) => {
    const {duration, currentTime} = e.srcElement;
    // console.log('duration', duration)
    // console.log('currentTime', currentTime)
    if (!duration || !currentTime) return;

    const progressPercentage = (currentTime / duration) * 100;
    progress.style.width = `${progressPercentage}%`;
    if(progressPercentage === 100){
        setSong(index + 1)
    }
}

const setCurrentTime = (e) => {
    // console.log(e.offsetX);
    const cursorX = e.offsetX;
    const containerWidth = progressContainer.offsetWidth;
    // console.log('containerWidth', containerWidth);
    player.currentTime = (cursorX / containerWidth) * player.duration
}


// Events handlers
playBtn.addEventListener('click', togglePlay);
prevBtn.addEventListener('click', () => setSong(index - 1));
nextBtn.addEventListener('click', () => setSong(index + 1));
// update audio progress
player.addEventListener('timeupdate', setProgress);
// set player song currentTime through click
progressContainer.addEventListener('click', setCurrentTime);
