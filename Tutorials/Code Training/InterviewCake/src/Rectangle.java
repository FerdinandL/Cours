public class Rectangle {

	// coordinates of bottom left corner
	Integer x;
	Integer y;

	// dimensions
	Integer width;
	Integer height;

	public Rectangle(Integer x, Integer y, Integer width, Integer height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public Rectangle() {
	}

	// Probleme avec le cas d'un rectangle qui contient l'autre
	public Rectangle intersect(Rectangle r2) {

		if (!(-r2.width <= r2.x - this.x && r2.x - this.x <= this.width)
				|| !(-r2.height <= r2.y - this.y && r2.y - this.y <= this.height)) {
			return null;
		}
		
		else {
			int intX = Math.max(this.x,r2.x);
			int intY = Math.max(this.y,r2.y);
			int w = (intX == this.x) ? r2.width - this.x + r2.x : this.width + this.x - r2.x;
			int h = (intY == this.y) ? r2.height - this.y + r2.y : this.height + this.y - r2.y;
			return new Rectangle(intX, intY, w, h);
		}
	}

	public String toString() {
		return String.format("(%d, %d, %d, %d)", x, y, width, height);
	}

	public static void main(String[] args) {
		Rectangle r2 = new Rectangle(2, 0, 6, 8);
		Rectangle r1 = new Rectangle(-3,-2,6,6);
		System.out.println(r1.intersect(r2));
	}
}
