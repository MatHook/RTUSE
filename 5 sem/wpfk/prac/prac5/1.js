document.onmousemove = () => {
  document.getElementsByTagName('body')[0].insertAdjacentHTML('beforeEnd', '<img src="1.jpg" id="png">');
  var png = document.getElementById('png');
  png.style.position = 'fixed';

  document.onmousemove = (event) => {
    png.style.left = event.clientX +5+'px';
    png.style.top = event.clientY +5+'px';
  }
}
