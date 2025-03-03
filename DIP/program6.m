//
img = imread("office_2.jpg");
r = double(img);
c = 1;
s = c * log(1 + r);
t = 255/(c * log(256));
b = uint8(t * s);
subplot(1,2,1);
imshow(img),title('Normal image');
subplot(1,2,2);
imshow(b),title('Log transformation');