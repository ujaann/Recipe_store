import "../css/RecipeForm.css";

const RecipeForm = () => {
    return (
        <section className="wrapper">
            <h2>Create Recipe</h2>
            <form className="form-container">
                <label className="form-label" htmlFor="recipe-name">
                    Recipe Name
                </label>
                <input
                    className="form-input"
                    id="recipe-name"
                    placeholder="Enter recipe name"
                    type="text"
                />
                <label className="form-label" htmlFor="recipe-description">
                    Recipe Description
                </label>
                <textarea
                    className="form-textarea"
                    id="recipe-description"
                    placeholder="Enter recipe description"
                    rows={4}
                />
                <label className="form-label" htmlFor="recipe-ingredients">
                    Ingredients
                </label>
                <textarea
                    className="form-textarea"
                    id="recipe-ingredients"
                    placeholder="Enter ingredients (one per line)"
                    rows={4}
                />
                <label className="form-label" htmlFor="recipe-steps">
                    Steps
                </label>
                <textarea
                    className="form-textarea"
                    id="recipe-steps"
                    placeholder="Enter steps (one per line)"
                    rows={4}
                />
                <button className="form-button">Submit Recipe</button>
            </form>
        </section>
    );
}

export default RecipeForm;