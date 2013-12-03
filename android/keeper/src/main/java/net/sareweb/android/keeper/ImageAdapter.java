package net.sareweb.android.keeper;

import java.util.List;

import net.sareweb.android.keeper.image.ImageLoader;
import net.sareweb.android.keeper.model.Image;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {

	private Context context;
	private List<Image> images;
	private ImageLoader imageLoader;

	public ImageAdapter(Context context, List<Image> images) {
		this.context = context;
		this.images = images;
		imageLoader = new ImageLoader(context);
	}

	@Override
	public int getCount() {
		if (images != null)
			return images.size();
		return 0;
	}

	@Override
	public Object getItem(int position) {
		if (images != null)
			return images.get(position);
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.image_row, null);
		}

		Image image = images.get(position);
		TextView txShotName = (TextView) convertView
				.findViewById(R.id.txShotName);
		txShotName.setText(image.getFile_name());
		ImageView imgShot = (ImageView) convertView.findViewById(R.id.imgShot);
		imageLoader.displayImage("http://keeper.sareweb.net:3000/assets/shots/"
				+ image.getFile_name(), imgShot);

		return convertView;
	}

}
